public abstract class View{

    protected Renderable r;
    protected Game game;
    
    public View(Renderable r){
        this.r = r;
    }

    public void setGame(Game game){
        this.game = game;
    }

    void render(World world){
        world.render(r);
    }

    abstract void launch();
}