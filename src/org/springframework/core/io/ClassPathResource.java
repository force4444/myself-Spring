package org.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource  implements Resource{

    private final String path;

    public ClassPathResource(String path){
        this.path = path;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(path);

        if(null == is){
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }

        return is;
    }
}
