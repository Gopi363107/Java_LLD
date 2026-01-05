// client class
public class Video_Streaming_Platform {
    public static void main(String [] args){
        Video video = new PlatinumPackageDecorator(new PremiumVideoDecorator(new BasicVideo()));

        System.out.println(video.play());
        System.out.println(video.cost());
    }
}

// component video interface
interface Video{
    String play();
    int cost();
}

// old class

class BasicVideo implements Video{
    @Override
    public String play(){
        return "Playing Basic Video";
    }

    @Override
    public int cost(){
        return 100;

    }
}

// decorator function
abstract class VideoDecorator implements Video{

    protected Video decoratedVideo;

    public VideoDecorator(Video decoratedVideo){
        this.decoratedVideo = decoratedVideo;
    }
}

// concrete decorator - HD Video
class HDVideoDecorator extends VideoDecorator{

    public HDVideoDecorator(Video decoratedVideo){
        super(decoratedVideo);
    }

    @Override
    public String play(){
        return decoratedVideo.play()+" in HD";
    }

    @Override
    public int cost(){
        return decoratedVideo.cost()+99;
    }
}

// concrete decorator - Premium Video

class PremiumVideoDecorator extends VideoDecorator{
    public PremiumVideoDecorator(Video decoratedVideo){
        super(decoratedVideo);
    }

    @Override
    public String play(){
        return decoratedVideo.play()+ " with Premium Features";
    }

    @Override
    public int cost(){
        return decoratedVideo.cost() + 299;
    }
}

// Concrete decorator - Platinum Package for family

class PlatinumPackageDecorator extends VideoDecorator{

    public PlatinumPackageDecorator(Video decoratedVideo){
        super(decoratedVideo);
    }

    @Override
    public String play(){
        return decoratedVideo.play() + " with Platinum Package";
    }

    @Override
    public int cost(){
        return decoratedVideo.cost() + 1999;
    }
}


