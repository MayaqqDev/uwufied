package dev.mayaqq.uwufied.mixin;

import dev.mayaqq.uwufied.UwuOrderedText;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.OrderedText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(TextRenderer.class)
public class TextRendererMixin {
    @ModifyVariable(
            method = "drawInternal(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;IIZ)I",
            at = @At(
                    value = "HEAD",
                    ordinal = 0
            ),
            argsOnly = true
    )
    private String modifyString(String text) {
        return uwufy(text);
    }

    @ModifyVariable(
            method = "drawInternal(Lnet/minecraft/text/OrderedText;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)I",
            at = @At(
                    value = "HEAD",
                    ordinal = 0
            ),
            argsOnly = true
    )
    private OrderedText modifyText(OrderedText text) {
        return new UwuOrderedText(text);
    }

    @Unique
    private static String uwufy(String original) {
        return original
                .replaceAll("r", "w")
                .replaceAll("R", "W")
                .replaceAll("l", "w")
                .replaceAll("L", "W")
                .replaceAll("u", "uwu")
                .replaceAll("U", "UwU")
                .replaceAll("hi ", "haiiii~ ")
                .replaceAll("Hi ", "Haiiii~ ")
                .replaceAll("\\.", ":3 ");
    }
}
