package com.wjp.service.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weijupeng
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractInfo {
    private String contractName;
    private String contractUrl;
}
