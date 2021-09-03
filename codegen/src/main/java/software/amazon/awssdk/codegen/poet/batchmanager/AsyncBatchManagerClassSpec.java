/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.codegen.poet.batchmanager;

import com.squareup.javapoet.ClassName;
import software.amazon.awssdk.codegen.model.intermediate.IntermediateModel;
import software.amazon.awssdk.codegen.poet.PoetExtensions;

public class AsyncBatchManagerClassSpec extends BaseBatchManagerClassSpec {

    private final IntermediateModel model;
    private final PoetExtensions poetExtensions;
    private final ClassName className;

    public AsyncBatchManagerClassSpec(IntermediateModel model) {
        super(model);
        this.model = model;
        this.poetExtensions = new PoetExtensions(model);
        this.className = poetExtensions.getBatchManagerAsyncClass();
    }

    @Override
    public ClassName className() {
        return className;
    }

    @Override
    protected ClassName clientClassName() {
        return poetExtensions.getClientClass(model.getMetadata().getAsyncInterface());
    }

    @Override
    protected ClassName interfaceClassName() {
        return poetExtensions.getBatchManagerAsyncInterface();
    }

    @Override
    protected boolean isSync() {
        return false;
    }
}