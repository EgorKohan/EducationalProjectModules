package net.codejava.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;

    private String photoStr;

    public String getPhotosImagePath() {
        if(photoStr == null || name == null) return null;
        return "user-photos/" + name + "/" + photoStr;
    }

}
