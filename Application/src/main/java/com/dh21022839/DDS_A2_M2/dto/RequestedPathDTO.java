package com.dh21022839.DDS_A2_M2.dto;

import com.dh21022839.DDS_A2_M2.mapping.Node;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestedPathDTO
{
    private Map<Node, Double> distances;
    private Map<Node, List<Node>> paths;
}
