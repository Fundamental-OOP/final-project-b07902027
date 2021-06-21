public abstract class View{

    protected Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public void render(World world){
        world.render(this.getRenderable());
    }

    abstract Renderable getRenderable();
    abstract public void launch();
}