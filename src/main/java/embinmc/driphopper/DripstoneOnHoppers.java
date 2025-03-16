package embinmc.driphopper;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DripstoneOnHoppers implements ModInitializer {
	public static final String MOD_ID = "driphopper";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final TagKey<Block> CAN_PLACE_ON = tag("dripstone_can_place_on");
	public static final TagKey<Block> CANNOT_PLACE_ON = tag("dripstone_cannot_place_on");

	private static TagKey<Block> tag(String name) {
		return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
	}

	@Override
	public void onInitialize() {
		LOGGER.info("dripstone on hoppers... what's next? air?");
	}
}