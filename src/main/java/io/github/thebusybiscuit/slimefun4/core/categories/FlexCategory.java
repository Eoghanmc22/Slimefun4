package io.github.thebusybiscuit.slimefun4.core.categories;

import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

/**
 * A {@link FlexCategory} is a {@link Category} inside the {@link SlimefunGuide} that can
 * be completely modified.
 * It cannot hold any {@link SlimefunItem} but can be completely overridden
 * to perform any action upon being opened.
 * 
 * @author TheBusyBiscuit
 *
 */
public abstract class FlexCategory extends Category {

    public FlexCategory(NamespacedKey key, ItemStack item) {
        this(key, item, 3);
    }

    public FlexCategory(NamespacedKey key, ItemStack item, int tier) {
        super(key, item, tier);
    }

    /**
     * This method returns whether this {@link FlexCategory} is visible under the given context.
     * Implementing this method gives full flexibility over who can see the Category when and where.
     * 
     * @param p
     *            The {@link Player} who opened his {@link SlimefunGuide}
     * @param profile
     *            The {@link PlayerProfile} of the {@link Player}
     * @param layout
     *            The {@link SlimefunGuideLayout} in which this {@link FlexCategory} is viewed
     * 
     * @return Whether to display this {@link FlexCategory}
     */
    public abstract boolean isVisible(Player p, PlayerProfile profile, SlimefunGuideLayout layout);

    public abstract void open(Player p, PlayerProfile profile, SlimefunGuideLayout layout);

    @Override
    public final boolean isHidden(Player p) {
        // We can stop this method right here.
        // We provide a custom method with more parameters for this. See isVisible(...)
        return false;
    }

    @Override
    public final void add(SlimefunItem item) {
        throw new UnsupportedOperationException("You cannot add items to a FlexCategory!");
    }

    @Override
    public final List<SlimefunItem> getItems() {
        throw new UnsupportedOperationException("A FlexCategory has no items!");
    }

}
