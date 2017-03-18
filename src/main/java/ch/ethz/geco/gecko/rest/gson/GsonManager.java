/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package ch.ethz.geco.gecko.rest.gson;

import ch.ethz.geco.gecko.rest.api.GecoAPI;
import ch.ethz.geco.gecko.rest.gson.deserializer.UserInfoDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonManager {
    private static boolean wasInitialized = false;
    private static Gson gson;

    private static void init() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(GecoAPI.UserInfo.class, new UserInfoDeserializer());
        gson = gsonBuilder.create();
    }

    public static Gson getGson() {
        if (wasInitialized) {
            return gson;
        } else {
            init();
            return gson;
        }
    }
}