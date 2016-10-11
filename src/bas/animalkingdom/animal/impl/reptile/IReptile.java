package bas.animalkingdom.animal.impl.reptile;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.IEggLayer;

/**
 * An {@link IReptile} interface for an {@link Animal} who is a {@link Reptile}.
 */
public interface IReptile extends IEggLayer {

    /**
     * Resolves the crawling of the {@link IReptile}
     *
     * @return The crawling of the {@link IReptile}
     */
    public String crawl();
}
