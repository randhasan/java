public class Draw
{
    public static void main(String[] args) {
        drawSquare(1,4,3);
    }
    
    public static void drawSquare(int x, int y, int len) {
        if (x>=0 && x<10 && y>=0 && y<10 && len>0) //precondition
        {
            if (x+len>=0 && x+len<10 && y-len>=0 && y-len<10)
            {
                System.out.println("side length = "+Integer.toString(len)+", area = "+Integer.toString((len*len)));
            }
            else if (!(x+len>=0 && x+len<10 && y-len>=0 && y-len<10))
            {
                len = 0;
                while (x+len>=0 && x+len<10 && y-len>=0 && y-len<10)
                {
                    len++;
                }
                System.out.println("side length = "+Integer.toString(len)+", area = "+Integer.toString((len*len)));
            }
        }
    }
}