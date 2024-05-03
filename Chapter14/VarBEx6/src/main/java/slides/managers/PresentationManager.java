package slides.managers;

import com.google.api.services.slides.v1.Slides;
import com.google.api.services.slides.v1.model.Page;
import com.google.api.services.slides.v1.model.Presentation;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class PresentationManager {
    private static final String PRESENTATION_ID = "18EUzC6DsWGWDklrA4e2PcUJ2Qn7yyfHNNScZUursZBg";

    public static Presentation getPresentation() throws IOException, GeneralSecurityException {
        Slides slidesService = slides.service.SlidesAuthService.getSlidesService();
        return slidesService.presentations().get(PRESENTATION_ID).execute();
    }

    public static List<Page> getSlides(Presentation presentation) {
        return presentation.getSlides();
    }
}
