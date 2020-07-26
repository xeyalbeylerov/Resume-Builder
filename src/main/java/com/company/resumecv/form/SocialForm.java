package com.company.resumecv.form;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class SocialForm {

    private String socialNetworkName;
    private String socialNetworkAddress;
}
