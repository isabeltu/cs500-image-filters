public class BrightnessFilter extends ImageFilter{


    //Brightens an image by a certain amount
    //Can also darken image if you enter a negative number for brightness amount


    private int brightnessAmount;

    public BrightnessFilter(int brightnessAmount){
        this.brightnessAmount = brightnessAmount;
    }

    public PixImage filterImage(PixImage image){
        PixImage copy = new PixImage(image);
        
        for (int i = 0; i < copy.red.length; i++){
            for (int j = 0; j < copy.red[i].length; j++){
                
                copy.red[i][j] += brightnessAmount;
                copy.green[i][j] += brightnessAmount;
                copy.blue[i][j] += brightnessAmount;
            }
        }
        
        return copy;
    }
}