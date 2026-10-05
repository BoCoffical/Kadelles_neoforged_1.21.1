package com.kadelles;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import org.slf4j.Logger;

@Mod(KadellesMod.MOD_ID)
public class KadellesMod {
    public static final String MOD_ID = "kadelles";
    private static final Logger LOGGER = LogUtils.getLogger();

    public KadellesMod(IEventBus modEventBus) {
        // 注册事件总线，让玩家登录事件能够被这个类捕获
        NeoForge.EVENT_BUS.register(this);
        LOGGER.info("凯德勒斯: 星火拓荒 核心系统正在加载...");
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        // 当玩家进入游戏时，在聊天栏发送提示
        event.getEntity().sendSystemMessage(Component.literal("§6[凯德勒斯] §f法则之网已初步展开..."));
        LOGGER.info("凯德勒斯: 玩家 {} 已接入法则网络。", event.getEntity().getName().getString());
    }
}