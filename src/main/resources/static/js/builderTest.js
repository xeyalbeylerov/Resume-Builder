$(document).ready(
    function () {
        let i = 0;
        console.log("ready! education");
        $("#addAction_education").click(
            function (e) {
                i++;
                e.preventDefault();
                console.log("FUNCTION education");
                $("#educationUL").append('    <li>\n' +
                    // '<button id="closeButton">close</button>\n' +
                    '                                    <div class="row">' +
                    '                                        <div class="form-group col">' +
                    '                                            <label for="educationHeader">Education header</label>' +
                    '                                            <input type="text" class="form-control" name="educations[' + i + '].educationHeader"' +
                    '                                                  placeholder="Here"  id="educationHeader" >' +
                    '                                        </div>' +
                    '                                    </div>' +
                    '                                    <div class="row">' +
                    '                                        <div class="form-group col">' +
                    '                                            <label for="educationBody">Education body</label>' +
                    '                                            <input type="text" name="educations[' + i + '].educationBody"' +
                    '                                                   class="form-control" id="educationBody" placeholder="Here">' +
                    '                                        </div>' +
                    '                                        <div class="form-group col">' +
                    '                                            <label for="educationDate">Education date</label>' +
                    '                                            <input type="date" name="educations[' + i + '].educationDate"' +
                    '                                                   class="form-control" id="educationDate" placeholder="Here">' +
                    '                                        </div>' +
                    '                                    </div>' +
                    '                                </li>');
            });
    }
);


$(document).ready(
    function () {
        let social = 0;
        console.log("ready social!");
        $("#addAction_social").click(
            function (e) {
                social++;
                e.preventDefault();
                console.log("FUNCTION social");
                $("#socialUl").append('<li>' +
                    '                        <div class="row">' +
                    '                        <div class="form-group col">' +
                    '                        <label for="socialLink">Social link</label>' +
                    '                    <input type="text" name="socials[' + social + '].socialNetworkName"' +
                    '                class="form-control" id="socialLink" placeholder="Here">' +
                    '                        </div>' +
                    '                        <div class="form-group col">' +
                    '                        <label for="socialAddress">Social address</label>' +
                    '                    <input type="text" name="socials[' + social + '].socialNetworkAddress"' +
                    '                class="form-control" id="socialAddress" placeholder="Here">' +
                    '                        </div>' +
                    '                        </div>' +
                    '                        </li>');
            });
    });

//skill JS
$(document).ready(
    function () {
        let skill = 0;
        console.log("ready skill!");
        $("#addAction_skill").click(
            function (e) {
                skill++;
                e.preventDefault();
                console.log("FUNCTION skill");
                $("#skillUl").append('  <li>' +
                    '                                    <div class="row">' +
                    '                                        <div class="form-group col">' +
                    '                                            <label for="skill_name">Skill name</label>' +
                    '                                            <input type="text" name="skills[' + skill + '].skillName"' +
                    '                                                   class="form-control" id="skill_name" placeholder="Here">' +
                    '                                        </div>' +
                    '                                        <div class="form-group col">' +
                    '                                            <label for="skill_power">Skill power</label>' +
                    '                                            <input type="range" value="0" min="0" max="100" step="10" name="skills[' + skill + '].power" class="form-control-range" id="skill_power">' +
                    '                                        </div>' +
                    '                                    </div>' +
                    '                                </li>');
            });
    });


//
// spinner start
$(document).ready(function () {
    showSpinnerWhileIFrameLoads();
});


function showSpinnerWhileIFrameLoads() {
    var iframe = $('iframe');
    if (iframe.length) {
        $(iframe).before('<div style="background-color: white;" id=\'spinner\'><i class=\'fa fa-spinner fa-spin fa-3x fa-fw\'></i></div>');
        $(iframe).on('load', function () {
            document.getElementById('spinner').style.display = 'none';
        });
    }
}
//spinner end

//resumeTemplate refersher start

//resumeTemplate refersher end
// Remove parent of 'remove' link when link is clicked.
// $(document).ready(function() {
//     $('#closeButton').on('click', function(e) {
//         $('#myUl').lastChild.remove();
//     });
// });


//

// $("#myUl").on('click', '#edu'+i, function(e) {
//     i--;
//     e.preventDefault();
//     $(this).parent().remove();
// });


//jquery append
// $('#addAction').click(function(e){
//     e.preventDefault();
//     $('#myUl').append('<li>')
// })