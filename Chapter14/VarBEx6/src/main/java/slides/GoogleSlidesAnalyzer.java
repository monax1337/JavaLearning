package slides;

import com.google.api.services.slides.v1.model.Page;
import com.google.api.services.slides.v1.model.Presentation;
import slides.managers.PresentationManager;
import slides.managers.SlideManager;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleSlidesAnalyzer {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        Presentation presentation = PresentationManager.getPresentation();

        String presentationTitle = presentation.getTitle();
        String presentationLocale = presentation.getLocale();
        System.out.println("Название презентации: " + presentationTitle);
        System.out.println("Локаль презентации: " + presentationLocale);

        List<Page> slides = PresentationManager.getSlides(presentation);
        System.out.println("Количество слайдов: " + slides.size());

        for (int i = 0; i < slides.size(); i++) {
            Page slide = slides.get(i);
            SlideManager.printSlideDetails(presentation, slide, i + 1);
        }
    }
}