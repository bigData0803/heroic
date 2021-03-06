/*
 * Copyright (c) 2015 Spotify AB.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.heroic.aggregation.simple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.heroic.aggregation.Aggregation;
import com.spotify.heroic.aggregation.AggregationContext;
import lombok.Data;

import java.util.Optional;

@Data
public class TopK implements Aggregation {
    public static final String NAME = "topk";

    private final long k;

    @JsonCreator
    public TopK(@JsonProperty("k") long k) {
        this.k = k;
    }

    @Override
    public Optional<Long> size() {
        return Optional.empty();
    }

    @Override
    public Optional<Long> extent() {
        return Optional.empty();
    }

    @Override
    public TopKInstance apply(final AggregationContext context) {
        return new TopKInstance(k);
    }
}
