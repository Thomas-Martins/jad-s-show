package com.jad.show;

import com.jad.customer.IVisitor;

public interface IShow {
    String getName();
    String getDescription();
    ShowType getShowType();
    void accept(IVisitor visitor);
}
