package lt.Shmup.Main.GameObject.Objects;

import lt.Shmup.Main.GameObject.Visitor;

import java.awt.*;

public interface Visitable {
    void acceptUpdateVisitor(Visitor visitor);
    void acceptRenderVisitor(Visitor visitor, Graphics2D graphics);
}
