package org.example.springbackend.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Cleanup;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("api/images")
@CrossOrigin(origins = "*")
public record ImageAPI() {

    @GetMapping(
            value = "/**",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageWithMediaType(HttpServletRequest request) throws IOException {
        String urlTail = new AntPathMatcher()
                .extractPathWithinPattern("/api/images/**", request.getRequestURI());
        @Cleanup
        InputStream in = new ClassPathResource("static/images/" + urlTail).getInputStream();
        return in.readAllBytes();
    }
}
