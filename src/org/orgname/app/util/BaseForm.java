package org.orgname.app.util;

import javax.swing.*;
import java.awt.*;

public abstract class BaseForm extends JFrame
{
    private static String baseApplicationTitle = "Application";

    private static Image baseApplicationImage = null;

    public BaseForm()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(getFormWidth(), getFormHeight()));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getFormWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getFormHeight() / 2
        );
        setTitle(baseApplicationTitle);
        if(baseApplicationImage != null) {
            setIconImage(baseApplicationImage);
        }
    }

    public abstract int getFormWidth();

    public abstract int getFormHeight();

    public static String getBaseApplicationTitle() {
        return baseApplicationTitle;
    }

    public static void setBaseApplicationTitle(String baseApplicationTitle) {
        BaseForm.baseApplicationTitle = baseApplicationTitle;
    }

    public static Image getBaseApplicationImage() {
        return baseApplicationImage;
    }

    public static void setBaseApplicationImage(Image baseApplicationImage) {
        BaseForm.baseApplicationImage = baseApplicationImage;
    }
}
