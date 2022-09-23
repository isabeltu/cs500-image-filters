
public class RedFilter extends ImageFilter
{
    
    private int redAmount;
    
    public RedFilter(int redAmount)
    {
        this.redAmount = redAmount;
    }
    
    public PixImage filterImage(PixImage image)
    {
        PixImage copy = new PixImage(image);
        
        for (int i = 0; i < copy.red.length; i++)
        {
            for (int j = 0; j < copy.red[0].length; j++)
            {
                copy.red[i][j] += redAmount * i;
            }
        }
        
        return copy;
    }
}
