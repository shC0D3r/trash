package utils;

import models.Hero;

import java.io.IOException;
import java.io.Serializable;

public abstract class HeroSerializator extends Hero implements Serializable {

    public static void writeObject(java.io.ObjectOutputStream out, Hero hero)
            throws IOException{
        out.writeLong(hero.getId());
        out.writeUTF(hero.getName());
        out.writeInt(hero.getLevel());
        out.writeUTF(hero.getUltimate());
        out.flush();
        out.close();
    }

    public static Hero readObject(java.io.ObjectInputStream inp)
            throws IOException{
        return new Hero(inp.readLong(),inp.readUTF(),inp.readInt(),inp.readUTF());
    }
}
