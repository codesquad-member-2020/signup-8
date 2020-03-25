//
//  NetworkHandler.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/25.
//  Copyright © 2020 신한섭. All rights reserved.
//

import Foundation

class NetworkHandler {
    class func request(resource: String){
        let defaultSession = URLSession(configuration: .default)
        guard let url = URL(string: resource) else {
            return
        }
        
        let request = URLRequest(url: url)
        
        let dataTask = defaultSession.dataTask(with: request) { (data: Data?, response: URLResponse?, error: Error?) in
            guard error == nil else {
                print("Error occur: \(String(describing: error))")
                
                return
            }
            
            guard let data = data, let response = response as? HTTPURLResponse, response.statusCode == 200 else {
                return
            }
            
            guard let jsonToArray = try? JSONSerialization.jsonObject(with: data, options: []) else {
                print("json to Any Error")
                
                return
            }
            
            guard let json = jsonToArray as? [String:Bool] else {return}
            if let state = json["isValid"] {
                NotificationCenter.default.post(name: .borderColor,
                                                object: nil,
                                                userInfo: ["borderColor" : state ? SignUpTextField.BorderColor.Green : SignUpTextField.BorderColor.Red])
                NotificationCenter.default.post(name: .isValidID,
                                                object: nil,
                                                userInfo: ["labelState": state ? StatusLabel.State.OK : StatusLabel.State.DuplicateID])
            }
        }
        
        dataTask.resume()
    }
}
