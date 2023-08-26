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
    @Unique
    private static String uwufyString(String input) {
        int stringLength = input.length();
        input = input
                .replaceAll("[rR]", "w").replaceAll("[lL]", "w")
                .replaceAll("ove", "uv").replaceAll("OVE", "UV")
                .replaceAll("o", "owo").replaceAll("O", "OwO")
                .replaceAll("!", "!!!").replaceAll("\\?", "???");
        if (stringLength % 3 == 0) {
            input = input.toUpperCase();
        }
        if (stringLength % 2 == 0) {
            input = input.replaceAll("(\\w)(\\b)", "$1$1$1$1$2");
        }
        if (!(stringLength % 2 == 0)) {
            input = input.replaceAll("\\b(\\w)(\\w*)\\b", "$1-$1$2");
        }
        String[] randomPhrases = {"UwU", "owo", "OwO", "uwu", ">w<", "^w^", "^-^", "^_^", "^w^", ":3"};
        input += " " + randomPhrases[stringLength % randomPhrases.length];
        return input;
    }

    @ModifyVariable(
            method = "drawInternal(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;IIZ)I",
            at = @At(
                    value = "HEAD",
                    ordinal = 0
            ),
            argsOnly = true
    )
    private String modifyString(String text) {
        return uwufyString(text);
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
}
