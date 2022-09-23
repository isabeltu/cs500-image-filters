public class RainbowFilter extends ImageFilter {


    private int thickness;

    public RainbowFilter(int thickness){
        this.thickness = thickness;
    }

    public PixImage filterImage(PixImage image){
        PixImage copy = new PixImage(image);


        for(int i = -thickness*10; i<copy.height+thickness*10; i++){

            int color = ((i+thickness*10)%(thickness*6))/thickness;

            
            int Ycoord = 0;

            for(int j = 0; j<copy.width; j++){
                

                Ycoord = equation((double)(j)/(double)(50)) + i;

                

                if(Ycoord >= 0 && Ycoord < copy.height){
                    copy.red[Ycoord][j] -= 50;
                    copy.green[Ycoord][j] -= 50;
                    copy.blue[Ycoord][j] -= 50;

                    if(color == 0){
                        copy.red[Ycoord][j] += 125;
                    }
                    if(color == 1){
                        copy.red[Ycoord][j] += 125;
                        copy.green[Ycoord][j] += 80;

                    }
                    if(color == 2){
                        copy.red[Ycoord][j] += 125;
                        copy.green[Ycoord][j] += 125;
                        copy.blue[Ycoord][j] += 25;

                    }
                    if(color == 3){
                        copy.green[Ycoord][j] += 125;

                    }
                    if(color == 4){
                        copy.blue[Ycoord][j] += 125;

                    }
                    if(color == 5){
                        copy.red[Ycoord][j] += 60;
                        copy.blue[Ycoord][j] += 60;

                    }
                }

            }

            
        }





        return copy;

    }

    public int equation(double x){
        return (int) (-40*(Math.sin(x) + Math.cos(2*x) - Math.sin(x/2) - Math.cos(x/4) + 3*Math.sin(x/2)) - x/3);
    }


    


    
}
