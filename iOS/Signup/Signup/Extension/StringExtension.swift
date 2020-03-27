//
//  StringExtension.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/25.
//  Copyright © 2020 신한섭. All rights reserved.
//

import Foundation

extension String {
    func validateID() -> Bool{
        let pattern = "^[a-z0-9_-]*$"
        let predicate = NSPredicate(format:"SELF MATCHES %@", pattern)
        
        return predicate.evaluate(with: self)
    }
}
