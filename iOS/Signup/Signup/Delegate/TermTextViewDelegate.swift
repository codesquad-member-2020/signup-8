//
//  TermTextViewDelegate.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/27.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class TermTextViewDelegate: NSObject, UITextViewDelegate {
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        let bottom = scrollView.contentSize.height - scrollView.bounds.size.height
        if scrollView.contentOffset.y >= bottom {
            NotificationCenter.default.post(name: .reachBottom,
                                            object: nil)
        }
    }
}

extension Notification.Name {
    static let reachBottom = Notification.Name("reachBottom")
}
