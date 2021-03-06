/*
 * Copyright 2014 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dominokit.jacksonapt.ser.map.key;

import org.dominokit.jacksonapt.JsonSerializationContext;

import java.util.Date;

/**
 * Default {@link org.dominokit.jacksonapt.ser.map.key.KeySerializer} implementation for {@link java.lang.Object}.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public final class ObjectKeySerializer extends KeySerializer<Object> {

    private static final ObjectKeySerializer INSTANCE = new ObjectKeySerializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link org.dominokit.jacksonapt.ser.map.key.ObjectKeySerializer}
     */
    public static ObjectKeySerializer getInstance() {
        return INSTANCE;
    }

    private ObjectKeySerializer() {
    }

    /** {@inheritDoc} */
    @Override
    protected String doSerialize(Object value, JsonSerializationContext ctx) {
        if (value instanceof Date) {
            return DateKeySerializer.getInstance().doSerialize((Date) value, ctx);
        } else {
            return ToStringKeySerializer.getInstance().doSerialize(value, ctx);
        }
    }
}
