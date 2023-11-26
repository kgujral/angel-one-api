package in.algomonkey.broker.angelone.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import in.algomonkey.broker.angelone.dto.data.CandleDataDto;

public class CandleDataMapper {

  public static List<CandleDataDto> convert(ArrayNode data) {
    List<CandleDataDto> list = new ArrayList<>();
    if (data == null || !data.isArray() || data.size() <= 0) {
      return list;
    }
    for (JsonNode node : data) {
      list.add(jsonNodeToCandleData(list, node));
    }
    return list;
  }

  private static CandleDataDto jsonNodeToCandleData(List<CandleDataDto> list, JsonNode node) {
    return CandleDataDto.builder()
      .timestamp(node.get(0).asText())
      .open(node.get(1).decimalValue())
      .high(node.get(2).decimalValue())
      .low(node.get(3).decimalValue())
      .close(node.get(4).decimalValue())
      .volume(node.get(5).decimalValue())
      .build();
  }

}
