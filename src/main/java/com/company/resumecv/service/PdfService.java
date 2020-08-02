package com.company.resumecv.service;

import com.company.resumecv.config.ResumeInitializerForTest;
import com.company.resumecv.form.ResumeForm;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.FileSystems;


@Service
@RequiredArgsConstructor
public class PdfService {
    //    Template engini aliriq
    private final SpringTemplateEngine templateEngine;
    private final ResumeInitializerForTest initializer;
    private final ResumeService resumeService;

    private static final String UTF_8 = "UTF-8";

    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }


    public ResumeForm generatePdf(ResumeForm resume) throws Exception {

        String resumeName = "resume_" + resume.getId() + ".pdf";
        resume.setResumeFileName(resumeName);

        resume = resumeService.update(resume);
        if (resume == null)
            resume = initializer.resumeBuilder();

//        Thymeleaf context
        Context context = new Context();
//        set resume to context
        context.setVariable("resume", resume);

        // Flying Saucer needs XHTML - not just normal HTML. To make our life
        // easy, we use JTidy to convert the rendered Thymeleaf template to
        // XHTML. Note that this might not work for very complicated HTML. But
        // it's good enough for a simple letter.

//        resume is html page name and this binding resume+context
        String renderedHtmlContent = templateEngine.process("resume", context);

        //        jsoup convert
        String xHtml = parseSpecialCharactersInData(renderedHtmlContent);

//        convert html to xhtml
        xHtml = convertToXhtml(xHtml);


//        this pdf render configuration
        ITextRenderer renderer = new ITextRenderer();
//        renderer.getFontResolver().addFont("Code39.ttf", IDENTITY_H, EMBEDDED);


        // FlyingSaucer has a working directory. If you run this test, the working directory
        // will be the root folder of your project. However, all files (HTML, CSS, etc.) are
        // located under "/src/test/resources". So we want to use this folder as the working
        // directory.
        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "resources")
                .toUri()
                .toURL()
                .toString();

//        set source xhtml and resources
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();

        // And finally, we create the PDF:
        //      set folder and image name
        File upl = new File("resumes/" + resumeName);

        //      Creating new file.Folder must be created before
        upl.createNewFile();

        //        write bytes to image file
        FileOutputStream fout = new FileOutputStream(upl);
        renderer.createPDF(fout);
        fout.close();

        return resume;

    }


    //converter jsoup experimental
    private
    String parseSpecialCharactersInData(String string) {
        Document parse = Jsoup.parse(string);
        return parse.html();
    }


//    get pdf file for download pdf
public FileSystemResource getPdfFile(ResumeForm resumeForm){
    File upl = new File("resumes/" + resumeForm.getResumeFileName());
    System.out.println(resumeForm.getResumeFileName());
    System.out.println(upl.getAbsolutePath());
    return new FileSystemResource(upl);
}

}
