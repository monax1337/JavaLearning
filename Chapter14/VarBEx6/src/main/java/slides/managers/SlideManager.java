package slides.managers;

import com.google.api.services.slides.v1.model.*;

import java.util.List;

public class SlideManager {
    public static void printSlideDetails(Presentation presentation, Page slide, int slideNumber) {
        System.out.println("Слайд " + slideNumber + ":");

        Size slideSize = presentation.getPageSize();
        double slideWidth = toPts(slideSize.getWidth());
        double slideHeight = toPts(slideSize.getHeight());
        System.out.println("Размер слайда: " + slideWidth + "x" + slideHeight + " пикселей");

        int elementsCount = countElementsOnSlide(slide);
        System.out.println("Количество элементов: " + elementsCount);
    }

    private static double toPts(Dimension dimension) {
        return switch (dimension.getUnit()) {
            case "EMU" -> dimension.getMagnitude() / 12700;
            case "PT" -> dimension.getMagnitude();
            default -> throw new RuntimeException("Недопустимая единица измерения: " + dimension.getUnit());
        };
    }

    private static int countElementsOnSlide(Page slide) {
        int count = 0;
        List<PageElement> elements = slide.getPageElements();
        if (elements != null) {
            count = elements.size();
        }
        return count;
    }
}
