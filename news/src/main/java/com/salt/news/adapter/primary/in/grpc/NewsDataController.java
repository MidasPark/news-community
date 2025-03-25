//package com.salt.news.adapter.primary.out.grpc;
//
//import com.salt.news.domain.news.response.NewsDataResponse;
//import com.salt.news.port.primary.out.rest.NewsDataPort;
//import com.salt.news.grpc.NewsServiceGrpc;
//import com.salt.news.grpc.UpdateNewsRequest;
//import com.salt.news.grpc.UpdateNewsResponse;
//import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;
//
//@GrpcService
//public class NewsDataController extends NewsServiceGrpc.NewsServiceImplBase {
//
//    private final NewsDataPort newsDataPort;
//
//    public NewsDataController(NewsDataPort newsDataPort) {
//        this.newsDataPort = newsDataPort;
//    }
//
//    @Override
//    public void updateNews(UpdateNewsRequest request, StreamObserver<UpdateNewsResponse> responseObserver) {
//        String categories = request.getCategories();
//        String keywords = request.getKeywords();
//
//        NewsDataResponse response = newsDataPort.fetchNewsArticles(categories, keywords);
//
//        UpdateNewsResponse grpcResponse = UpdateNewsResponse.newBuilder()
//                .setMessage("updateNews running!")
//                .build();
//
//        responseObserver.onNext(grpcResponse);
//        responseObserver.onCompleted();
//    }
//}
