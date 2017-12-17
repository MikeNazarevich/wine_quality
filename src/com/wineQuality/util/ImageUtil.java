package com.wineQuality.util;

import javax.swing.ImageIcon;

public class ImageUtil
{

    public ImageIcon loadIcon(String path)
    {

        return new ImageIcon(getClass().getResource("/com/wineQuality/view/assets/" + path));
    }

}
