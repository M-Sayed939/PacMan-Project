package Project.Maps.Map4;

import Project.AnimListener;
import Project.texture.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Map4Listener extends AnimListener {

    int[][] map = new int[][]{
            {1,1,0,1,1,1,0,1,1,1},
            {0,1,0,1,0,1,0,1,0,0},
            {0,1,1,1,0,1,1,1,1,0},
            {0,1,0,1,1,1,0,0,1,0},
            {0,1,1,0,1,1,0,1,1,0},
            {0,0,1,0,0,0,0,1,0,0},
            {0,1,1,1,1,1,1,1,1,0},
            {0,1,0,1,0,0,0,1,0,0},
            {0,1,0,1,0,0,0,1,0,0},
            {0,1,1,1,1,1,1,1,1,0},
    };

    String textureName = "";
    TextureReader.Texture texture;
    int textureIndex[] = new int[1];

    /*
     5 means gun in array pos
     x and y coordinate for gun
     */
    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        //number of textures,array to hold the indeces
        gl.glGenTextures(1, textureIndex, 0);

        try {
            texture = TextureReader.readTexture(assetsFolderName + "//" + textureName , true);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
            new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, // Internal Texel Format,
                    texture.getWidth(), texture.getHeight(),
                    GL.GL_RGBA, // External format from image,
                    GL.GL_UNSIGNED_BYTE,
                    texture.getPixels() // Imagedata
            );
        } catch( IOException e ) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
