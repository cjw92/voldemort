/*
 * Copyright 2010 LinkedIn, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package voldemort.store.routed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import voldemort.cluster.Node;

public class BasicPipelineData<V> extends PipelineData {

    private final List<Response<V>> responses;

    private List<Node> nodes;

    private final AtomicInteger nodeIndex;

    private final AtomicInteger successes;

    public BasicPipelineData() {
        this.responses = new ArrayList<Response<V>>();
        this.nodeIndex = new AtomicInteger(0);
        this.successes = new AtomicInteger(0);
    }

    public List<Response<V>> getResponses() {
        return responses;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public int getNodeIndex() {
        return nodeIndex.get();
    }

    public void incrementNodeIndex() {
        nodeIndex.incrementAndGet();
    }

    public int getSuccesses() {
        return successes.get();
    }

    public void incrementSuccesses() {
        successes.incrementAndGet();
    }

}
