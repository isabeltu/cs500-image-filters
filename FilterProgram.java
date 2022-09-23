
/**
 * Here we have a main method that loads an image, applies and filter to
 * it and then displays the modified image to the screen
 */
public class FilterProgram
{
    public static void main(String [] args)
    {
        //load the image
        //PixImage ml = new PixImage("MonaLisa.jpg");
        
        //ImageFilter red = new RedFilter(1);
        //PixImage redLisa = red.filterImage(ml);
        

        //ImageFilter brighter = new BrightnessFilter(100);
        //PixImage brightLisa = brighter.filterImage(ml);


        //ImageFilter darker = new BrightnessFilter(-100);
        //PixImage darkLisa = darker.filterImage(ml);

        
        //brightLisa.showImage();
        //darkLisa.showImage();
        //ml.saveImage("hello.png");
        
        //ml.showImage();

        //System.out.println(ml.height + " " + ml.width);

        PixImage ml = new PixImage("night.jpg");

        //ml.showImage();

        
        ImageFilter small = new SmallFilter(60);

        PixImage smallLisa = small.filterImage(ml);

        smallLisa.showImage();
        //smallLisa.saveImage("medium.png");

        /*

        ImageFilter small2 = new SmallFilter(40);

        PixImage smallLisa2 = small2.filterImage(ml);

        smallLisa2.showImage();
        //smallLisa2.saveImage("biggest.png");

        ImageFilter small3 = new SmallFilter(100);

        PixImage smallLisa3 = small3.filterImage(ml);

        smallLisa3.showImage();
        //smallLisa3.saveImage("smallest.png");

        */
        

        ImageFilter rainbow = new RainbowFilter(40);
        PixImage rainbowLisa = rainbow.filterImage(ml);
        rainbowLisa.showImage();




    }
}
