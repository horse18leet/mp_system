package org.openapitools.api;

import org.openapitools.model.ContentV1BarcodesPost200Response;
import org.openapitools.model.ContentV1BarcodesPostRequest;
import org.openapitools.model.ContentV1CardsCursorListPost200Response;
import org.openapitools.model.ContentV1CardsCursorListPostRequest;
import org.openapitools.model.ContentV1CardsErrorListGet200Response;
import org.openapitools.model.ContentV1CardsFilterPost200Response;
import org.openapitools.model.ContentV1CardsFilterPostRequest;
import org.openapitools.model.ContentV1CardsLimitsGet200Response;
import org.openapitools.model.ContentV1CardsMoveNmPost400Response;
import org.openapitools.model.ContentV1CardsMoveNmPostRequest;
import org.openapitools.model.ContentV1CardsTrashListPost200Response;
import org.openapitools.model.ContentV1CardsTrashListPostRequest;
import org.openapitools.model.ContentV1CardsUpdatePost200Response;
import org.openapitools.model.ContentV1CardsUpdatePostRequestInner;
import org.openapitools.model.ContentV1CardsUploadAddPostRequest;
import org.openapitools.model.ContentV1DirectoryColorsGet200Response;
import org.openapitools.model.ContentV1DirectoryCountriesGet200Response;
import org.openapitools.model.ContentV1DirectoryKindsGet200Response;
import org.openapitools.model.ContentV1DirectorySeasonsGet200Response;
import org.openapitools.model.ContentV1DirectoryTnvedGet200Response;
import org.openapitools.model.ContentV1MediaSavePostRequest;
import org.openapitools.model.ContentV1ObjectAllGet200Response;
import org.openapitools.model.ContentV1ObjectCharacteristicsListFilterGet200Response;
import org.openapitools.model.ContentV1ObjectCharacteristicsObjectNameGet200Response;
import org.openapitools.model.ContentV1ObjectParentAllGet200Response;
import org.openapitools.model.ContentV1TagIdDelete200Response;
import org.openapitools.model.ContentV1TagIdDelete200Response1;
import org.openapitools.model.ContentV1TagIdDelete400Response;
import org.openapitools.model.ContentV1TagIdDelete400Response1;
import org.openapitools.model.ContentV1TagIdDeleteRequest;
import org.openapitools.model.ContentV1TagNomenclatureLinkPostRequest;
import org.openapitools.model.ContentV1TagPost400Response;
import org.openapitools.model.ContentV1TagPostRequest;
import org.openapitools.model.ContentV1TagsGet200Response;
import org.openapitools.model.CreatingCardInnerInner;
import java.util.List;
import org.openapitools.model.ResponseBodyContentError400;
import org.openapitools.model.ResponseBodyContentError403;
import org.openapitools.model.ResponseCardCreate;
import org.openapitools.model.ResponseContentError4;
import org.openapitools.model.ResponseContentError6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
@Controller
public class ContentApiController implements ContentApi {

    private final NativeWebRequest request;

    @Autowired
    public ContentApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
