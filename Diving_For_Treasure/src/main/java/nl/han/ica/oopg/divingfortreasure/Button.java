package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PGraphics;

public abstract class Button extends GameObject implements IMouseInput {
    private String text;

    Button(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
    }

    public void mouseClicked(int x, int y, int button){
        if (this.x - this.width / 2 < x && this.y - this.width / 2 < y && this.x + this.width / 2 > x && this.y + this.height / 2 > y)
        action();
    }

    public abstract void action();

    @Override
    public void draw(PGraphics g) {
        g.fill(50, 200, 235);
        g.rectMode(CENTER);
        g.rect(this.x, this.y, this.width, this.height, 20);
        g.fill(0);
        g.textSize(30);
        g.textAlign(CENTER, CENTER);
        g.text(this.text, this.x , this.y);
    }

    @Override
    public void update() {

    }
}
