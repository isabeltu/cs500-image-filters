
public class WarholFilter extends ImageFilter{



    public PixImage filterImage(PixImage image){
        PixImage copy = new PixImage(image);

        PixImage quarterImage = quarterImage(image);
        PixImage firstQuarter = new PixImage(quarterImage);
        PixImage secondQuarter = new PixImage(quarterImage);
        PixImage thirdQuarter = new PixImage(quarterImage);
        PixImage fourthQuarter = new PixImage(quarterImage);

        for(int i = 0; i<quarterImage.height; i++){
            for(int j = 0; j<quarterImage.width; j++){
                //filter first quarter

                firstQuarter.red[i][j] += 100;

                
                //filter second quarter

                secondQuarter.green[i][j] += 100;


                //filter third quarter

                thirdQuarter.blue[i][j] += 100;


                //filter fourth quarter


                fourthQuarter.red[i][j] += 50;
                fourthQuarter.green[i][j] += 50;



                //combine
                copy.red[i][j] = firstQuarter.red[i][j];
                copy.green[i][j] = firstQuarter.green[i][j];
                copy.blue[i][j] = firstQuarter.blue[i][j];

                copy.red[i][copy.width/2 + j] = secondQuarter.red[i][j];
                copy.green[i][copy.width/2 + j] = secondQuarter.green[i][j];
                copy.blue[i][copy.width/2 + j] = secondQuarter.blue[i][j];

                copy.red[copy.height/2 + i][j] = thirdQuarter.red[i][j];
                copy.green[copy.height/2 + i][j] = thirdQuarter.green[i][j];
                copy.blue[copy.height/2 + i][j] = thirdQuarter.blue[i][j];

                copy.red[copy.height/2 + i][copy.width/2 + j] = fourthQuarter.red[i][j];
                copy.green[copy.height/2 + i][copy.width/2 + j] = fourthQuarter.green[i][j];
                copy.blue[copy.height/2 + i][copy.width/2 + j] = fourthQuarter.blue[i][j];

            }
        }


        return copy;
    }

    public PixImage quarterImage(PixImage image){

        int height = image.height/2;
        int width = image.width/2;

        PixImage copy = new PixImage(height, width);

        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                //System.out.println(i + " " + j);

                
                int redTot = 0;
                int greenTot = 0;
                int blueTot = 0;
                for(int k = 2*i; k<2*i+2; k++){
                    for(int l = 2*j; l<2*j+2; l++){
                        redTot += image.red[k][l];
                        greenTot += image.green[k][l];
                        blueTot += image.blue[k][l];
                    }
                }

                copy.red[i][j] = redTot/4;
                copy.green[i][j] = greenTot/4;
                copy.blue[i][j] = blueTot/4;
            }
        }

        return copy;
    }

    
}
