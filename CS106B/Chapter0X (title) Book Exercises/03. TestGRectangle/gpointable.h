#ifndef GPOINTABLE_H
#define GPOINTABLE_H


class Gpointable {
public:
    Gpointable();

    Gpointable(double xc, double yc);

    double getX() const;

    double getY() const;

    int x;
    int y;
};



#endif // GPOINTABLE_H
