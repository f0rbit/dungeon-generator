package dev.forbit;

import dev.forbit.enums.DefaultAttributes;
import dev.forbit.implementation.RandomGeneration;
import dev.forbit.interfaces.Cell;
import dev.forbit.interfaces.Floor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class Visualiser {

    public static void main(String[] args) {

        RandomGeneration generator = new RandomGeneration();
        Optional<Floor> f = generator.generate(8, 8);
        if (f.isEmpty()) {
            System.out.println("Couldn't generate a floor!");
            return;
        }
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.getColor("#151515"));
        graphics.fillRect(-1, -1, 402, 402);
        draw(f.get(), graphics);
        JOptionPane.showMessageDialog(null, new ImageIcon(image), "Dungeon", JOptionPane.INFORMATION_MESSAGE);


    }


    private static void draw(Floor f, Graphics2D graphics) {
        for (Cell t : f.getCells()) {
            if (t != null) {
                if (t.getAttributes().contains(DefaultAttributes.END_ROOM)) {
                    if (t.getAttributes().contains(DefaultAttributes.START_ROOM)) {
                        graphics.setPaint(Color.GREEN);
                    } else {
                        graphics.setPaint(Color.RED);
                    }
                } else {

                    graphics.setPaint(Color.GRAY);
                }

                graphics.fillRect(t.getX() * 32, t.getY() * 32, 32, 32);
            }

        }
    }
}
