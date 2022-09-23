public class SmallFilter extends ImageFilter {
    private int num;
    public SmallFilter(int num){
        this.num = num;
    }

    public PixImage filterImage(PixImage image){
        PixImage copy = new PixImage(image);

        
        
        
        
        

        
        
        PixImage smallImage = smallImage(copy);

        int hNum = image.height/smallImage.height;
        int wNum = image.width/smallImage.width;

        PixImage pixels = new PixImage(hNum, wNum);
        for(int i = 0; i < hNum; i++){
            for(int j = 0; j<wNum; j++){
                int redTot = 0;
                int greenTot = 0;
                int blueTot = 0;

                for(int k = (copy.height/hNum)*i; k<(copy.height/hNum)*(i+1); k++){
                    for(int l = (copy.width/wNum)*j; l<(copy.width/wNum)*(j+1); l++){
                        redTot += image.red[k][l];
                        greenTot += image.green[k][l];
                        blueTot += image.blue[k][l];

                    }
                }

                pixels.red[i][j] = redTot*hNum*wNum/copy.height/copy.width;
                pixels.green[i][j] = greenTot*hNum*wNum/copy.height/copy.width;
                pixels.blue[i][j] = blueTot*hNum*wNum/copy.height/copy.width;
            }
        }

        PixImage result = new PixImage(smallImage.height * hNum, smallImage.width * wNum);

        for(int i = 0; i<hNum; i++){
            for(int j = 0; j<wNum; j++){
                int height = smallImage.height;
                int width = smallImage.width;
                for(int k = 0; k<height; k++){
                    for(int l = 0; l<width; l++){
                        //System.out.println(i + " " + j + " " + k + " " + l);
                        result.red[height*i+k][width*j+l] = smallImage.red[k][l] - 40 + pixels.red[i][j]/2;
                        result.green[height*i+k][width*j+l] = smallImage.green[k][l] - 40 + pixels.green[i][j]/2;
                        result.blue[height*i+k][width*j+l] = smallImage.blue[k][l] - 40 + pixels.blue[i][j]/2;
                    }
                }
            }
        }

        return result;
    }

    


    public PixImage smallImage(PixImage image){

        int height = (image.height)/num;
        int width = (image.width)/num;

        PixImage copy = new PixImage(height, width);

        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){

                
                int redTot = 0;
                int greenTot = 0;
                int blueTot = 0;
                for(int k = num*i; k<num*i+num && k<image.height; k++){
                    for(int l = num*j; l<num*j+num && l<image.width; l++){
                        redTot += image.red[k][l];
                        greenTot += image.green[k][l];
                        blueTot += image.blue[k][l];
                    }
                }

                copy.red[i][j] = redTot/num/num;
                copy.green[i][j] = greenTot/num/num;
                copy.blue[i][j] = blueTot/num/num;
            }
        }

        return copy;
    }



}
