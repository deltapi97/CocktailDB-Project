package Controller;

import javax.swing.*;
import java.awt.*;

public class ComboRenderer extends JLabel implements ListCellRenderer<Object> {

    private String title;

    public ComboRenderer(String _title) {
        this.title = _title;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean hasFocus) {
        if (index == -1 && value == null)
            setText(title);
        else
            setText(value.toString());
        return this;
    }
}