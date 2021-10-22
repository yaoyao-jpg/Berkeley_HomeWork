/** A class that represents a path via pursuit curves. */
public class Path {

    // TODO
    private Point curr=new Point(0,0);
    private Point next;

    Path(double x,double y)
    {
        curr=new Point(x,y);
    }

    Path()
    {
        curr=new Point(0,0);
    }

    double getCurrX()
    {
        return curr.getX();
    }

    double getCurrY()
    {
        return curr.getY();
    }

    double getNextX()
    {
        return next.getX();
    }

    double getNextY()
    {
        return next.getY();
    }

    Point getCurrentPoint()
    {
        return curr;
    }

    void setCurrentPoint(Point point)
    {
        curr=point;
    }

    void iterate(double dx, double dy)
    {
        if(next==null)
        {
            curr=new Point(0,0);
            next=new Point(curr.getX()+dx,curr.getY()+dy);
        }
        else {
            curr = next;
            next = new Point(curr.getX() + dx, curr.getY() + dy);
        }
    }







}
