
/**
 * This is the base (parent) class for manipulating images
 * 
 */
public class ImageFilter
{
    public ImageFilter()
    {
        
    }
    
    //This method should be overwritten in the child classes
    //it takes in an image, applies a filter to it, and then
    //returns the modified image
    public PixImage filterImage(PixImage image)
    {
        return image;
    }
}
