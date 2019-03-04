/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.common.utils;

import io.renren.modules.sys.entity.SysLogEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Layui分页
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0 2018-03-12
 */
public class LayuiPage implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = 0;
    //总记录数
    private int count;
    //列表数据
    private List<?> data;

    public LayuiPage(List<?> data, int count) {
        this.data = data;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
