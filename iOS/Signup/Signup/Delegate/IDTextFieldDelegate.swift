//
//  IDTextFieldDelegate.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/24.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class IDTextFieldDelegate: NSObject, UITextFieldDelegate {
    
    private let serverURL = "http://www.mocky.io/v2/5e7b54482d00006100119f28"
    
    func textFieldDidChangeSelection(_ textField: UITextField) {
        let length = textField.text?.count ?? 0
        
        if length < 5 {
            postBorderColorNotifcation(state: .Red)
            postLabelStatusNotification(state: .ShortLength)
        } else if length > 20 {
            postBorderColorNotifcation(state: .Red)
            postLabelStatusNotification(state: .LongLength)
        } else {
            if textField.text!.validateID() {
                NetworkHandler.request(resource: serverURL){
                    debugPrint($0)
                }
            } else {
                postBorderColorNotifcation(state: .Red)
                postLabelStatusNotification(state: .InvalidID)
            }
        }
    }

    func postLabelStatusNotification(state: StatusLabel.State) {
        NotificationCenter.default.post(name: .isValidID,
                                        object: nil,
                                        userInfo: ["labelState" : state])
    }
    
    func postBorderColorNotifcation(state: SignUpTextField.BorderColor) {
        NotificationCenter.default.post(name: .borderColor,
                                        object: nil,
                                        userInfo: ["borderColor" : state])
    }
}

extension Notification.Name {
    static let isValidID = Notification.Name("isValidID")
    static let borderColor = Notification.Name("borderColor")
}


