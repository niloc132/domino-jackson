/*
 * Copyright 2013 Nicolas Morel
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

package org.dominokit.jacksonapt.deser.collection;

import org.dominokit.jacksonapt.JsonDeserializationContext;
import org.dominokit.jacksonapt.JsonDeserializer;

/**
 * Base {@link org.dominokit.jacksonapt.JsonDeserializer} implementation for {@link java.lang.Iterable}.
 *
 * @param <I> {@link java.lang.Iterable} type
 * @param <T> Type of the elements inside the {@link java.lang.Iterable}
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class BaseIterableJsonDeserializer<I extends Iterable<T>, T> extends JsonDeserializer<I> {

    protected final JsonDeserializer<T> deserializer;

    /**
     * <p>Constructor for BaseIterableJsonDeserializer.</p>
     *
     * @param deserializer {@link org.dominokit.jacksonapt.JsonDeserializer} used to map the objects inside the {@link java.lang.Iterable}.
     */
    public BaseIterableJsonDeserializer(JsonDeserializer<T> deserializer) {
        if (null == deserializer) {
            throw new IllegalArgumentException("deserializer can't be null");
        }
        this.deserializer = deserializer;
    }

    /** {@inheritDoc} */
    @Override
    public void setBackReference(String referenceName, Object reference, I value, JsonDeserializationContext ctx) {
        if (null != value) {
            for (T val : value) {
                deserializer.setBackReference(referenceName, reference, val, ctx);
            }
        }
    }
}
