package dtcc.itn261;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;

// set up logging for errors instead of print stacktrace
public class BannerImage extends ImageView {
    private static final String IMAGE_LOCATION = "src/main/resources/dtcc/itn261/assignment_9/images/dtcc_background2.jpg";
    private static final Logger LOGGER = Logger.getLogger(BannerImage.class.getName());

    public BannerImage(ReadOnlyDoubleProperty widthProperty) {
        try {
            Image backgroundImage = new Image(new FileInputStream(IMAGE_LOCATION));
            this.setImage(backgroundImage);
            this.setPreserveRatio(false);
            this.fitWidthProperty().bind(widthProperty);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, "Banner image not found: " + IMAGE_LOCATION, e);
        }

    }
}
