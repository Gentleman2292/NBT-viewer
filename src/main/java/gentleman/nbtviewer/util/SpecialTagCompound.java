package gentleman.nbtviewer.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class SpecialTagCompound extends NbtCompound {

    public static int getStackDamage(ItemStack stack) {
        NbtCompound tag = stack.getNbt();
        if (tag != null && tag instanceof SpecialTagCompound) {
            return ((SpecialTagCompound) tag).getTrueDamage();
        }
        return stack.getDamage();
    }

    private boolean empty;
    private final int true_damage;

    public SpecialTagCompound(boolean empty, int true_damage) {
        this.empty = empty;
        this.true_damage = true_damage;
    }

    public SpecialTagCompound(NbtCompound old, int true_damage) {
        super();
        if (old == null) this.empty = true;
        else {
            for (String key : old.getKeys()) {
                this.put(key, old.get(key));
            }
        }
        this.true_damage = true_damage;
    }

    public int getTrueDamage() {
        return this.true_damage;
    }

    public byte getType() {
        if (this.empty) return 0;
        return super.getType();
    }

    public NbtCompound copy() {
        SpecialTagCompound copy = new SpecialTagCompound(this.empty, this.true_damage);

        for (String key : this.getKeys()) {
            copy.put(key, this.get(key).copy());
        }

        return copy;
    }

    public boolean isEmpty() { // do not clear me
        if (super.isEmpty()) {
            this.empty = true;
        }
        return false;
    }

    public void put(String key, NbtCompound value) {
        this.empty = false;
        super.put(key, value);
    }

    public void putInt(String key, int value) {
        this.empty = false;
        super.putInt(key, value);
    }

    public void putByte(String key, byte value) {
        this.empty = false;
        super.putByte(key, value);
    }

    public void putShort(String key, short value) {
        this.empty = false;
        super.putShort(key, value);
    }

    public void putLong(String key, long value) {
        this.empty = false;
        super.putLong(key, value);
    }

    public void putUuid(String key, UUID value) {
        this.empty = false;
        super.putUuid(key, value);
    }

    public void putFloat(String key, float value) {
        this.empty = false;
        super.putFloat(key, value);
    }

    public void putDouble(String key, double value) {
        this.empty = false;
        super.putDouble(key, value);
    }

    public void putString(String key, String value) {
        this.empty = false;
        super.putString(key, value);
    }

    public void putByteArray(String key, byte[] value) {
        this.empty = false;
        super.putByteArray(key, value);
    }

    public void putIntArray(String key, int[] value) {
        this.empty = false;
        super.putIntArray(key, value);
    }
}
